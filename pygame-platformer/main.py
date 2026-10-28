import pygame as pg
from pygame import *
import json
from typing import Final

init()
TITLE: Final[str] = "Girl Platformer"
W, H = SIZE = 1000, 1000

scr: Surface = display.set_mode(
    SIZE
)
pg.display.set_caption(
    TITLE
)
pg.display.set_icon(
    pg.image.load(
        "img/icon.png"
    )
)
clock: time.Clock = time.Clock()


# game variables
# constants
FPS: Final[int] = 60
TILE_SIZE: Final[int] = 50
LEVEL_DATA_FALLBACK: Final[list[list[int]]] = [
    [1,] * 20,
    [1, *[0,] * 18, 1],
    [1, *[0,] * 4, 7, *[0,] * 12, 8, 1],
    [1, *[0,] * 4, 2, *[0,] * 5, 7, *[0,] * 5, *[2,] * 2, 1],
    [1, *[0,] * 9, *[2,] * 2, 0, 7, 0, 5, *[0,] * 3, 1],
    [1, *[0,] * 7, 5, *[0,] * 3, *[2,] * 2, *[0,] * 5, 1],
    [1, 7, *[0,] * 2, *[2,] * 3, *[0,] * 12, 1],
    [1, 2, *[0,] * 17, 1],
    [1, *[0] * 10, 7, *[0,] * 2, 7, *[0,] * 4, 1],
    [1, 0, 2, *[0,] * 2, 7, 0, 7, *[0,] * 11, 1],
    [1, 0, 0, 2, 0, 0, 4, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 1],
    [1, *[0,] * 8, *[2,] * 7, *[0,] * 3, 1],
    [1, *[0,] * 18, 1],
    [1, *[0,] * 9, 7, 0, 7, *[0,] * 4, 2, 0, 1],
    [1, *[0,] * 18, 1],
    [1, *[0,] * 9, 2, 0, 2, 0, *[2,] * 5, 1],
    [1, *[0,] * 5, *[2,] * 3, *[6,] * 5, *[1,] * 6],
    [1, *[0] * 4, 2, *[1,] * 14],
    [1, *[0,] * 3, 2, *[1,] * 15],
    [1, *[2,] * 3, *[1,] * 16]
]
MAX_LEVELS: Final[int] = 6
FONT: Final[str] = pg.font.SysFont(
    "Arial",
    60
)
SCORE_FONT: Final[str] = pg.font.SysFont(
    "Arial",
    24
)
# dynamic
game_over: int = 0
is_main_menu: bool = True
level: int = 1
score: int = 0

# load images
bg_img: Surface = image.load(
    "img/sky.png"
)
sun_img: Surface = image.load(
    "img/sun.png"
)
restart_img: Surface = image.load(
    "img/restart_btn.png"
)
start_img: Surface = image.load(
    "img/start_btn.png"
)
exit_img: Surface = image.load(
    "img/exit_btn.png"
)

# sprite groups
blob_group: pg.sprite.Group\
    = pg.sprite.Group()
lava_group: pg.sprite.Group\
    = pg.sprite.Group()
exit_group: pg.sprite.Group\
    = pg.sprite.Group()
coin_group: pg.sprite.Group\
    = pg.sprite.Group()


class Enemy(
    pg.sprite.Sprite
):
    def __init__(
        self,
        x: int,
        y: int
    ) -> None:
            if not isinstance(
                x,
                int
            ):
                x = 0
            if not isinstance(
                y,
                int
            ):
                y = 0
            super().__init__()
            self.image: Surface = image.load(
                "img/blob.png"
            )
            self.rect: Rect = self.image.get_rect()
            self.rect.x: int = x
            self.rect.y: int = y
            self.move_direction: int = 1
            self.move_counter: int = 0
    def update(
        self
    ) -> None:
            self.rect.x += self.move_direction
            self.move_counter += 1
            if abs(self.move_counter) > 50:
                self.move_direction *= -1
                self.move_counter *= -1

class Lava(
    pg.sprite.Sprite
):
    def __init__(
        self,
        x: int,
        y: int
    ) -> None:
            if not isinstance(
                x,
                int
            ):
                x = 0
            if not isinstance(
                y,
                int
            ):
                y = 0
            super().__init__()
            img: Surface = image.load(
                "img/lava.png"
            )
            img_scaled: Surface = pg.transform.scale(
                img,
                (TILE_SIZE, TILE_SIZE // 2)
            )
            self.image: Surface = img_scaled
            self.rect: Rect = self.image.get_rect()
            self.rect.x: int = x
            self.rect.y: int = y

class Exit(
    pg.sprite.Sprite
):
    def __init__(
        self,
        x: int,
        y: int
    ) -> None:
            if not isinstance(
                x,
                int
            ):
                x = 0
            if not isinstance(
                y,
                int
            ):
                y = 0
            super().__init__()
            img: Surface = image.load(
                "img/exit.png"
            )
            img_scaled: Surface = pg.transform.scale(
                img,
                (TILE_SIZE, int(TILE_SIZE * 1.2))
            )
            self.image: Surface = img_scaled
            self.rect: Rect = self.image.get_rect()
            self.rect.x: int = x
            self.rect.y: int = y

class Coin(
    pg.sprite.Sprite
):
    def __init__(
        self,
        x: int,
        y: int
    ) -> None:
            if not isinstance(
                x,
                int
            ):
                x = 0
            if not isinstance(
                y,
                int
            ):
                y = 0
            super().__init__()
            img: Surface = image.load(
                "img/coin.png"
            )
            img_scaled: Surface = pg.transform.scale(
                img,
                (TILE_SIZE // 2, TILE_SIZE // 2)
            )
            self.image: Surface = img_scaled
            self.rect: Rect = self.image.get_rect()
            self.rect.center: tuple[int, int] = (x, y)

# show a coin
# (a score counter)
# at the top left
# corner
# of the screen
score_coin: Coin = Coin(
    TILE_SIZE // 2,
    TILE_SIZE // 2
)
coin_group.add(
    score_coin
)

class World:
    def __init__(self, data: list[list[int]]) -> None:
        self.tiles: list[tuple[Surface, Rect]] = []
        dirt_img: Surface = image.load("img/dirt.png")
        grass_img: Surface = image.load("img/grass.png")
        img: Optional[Surface] = None
        for row_count, row in enumerate(data):
            for col_count, tile in enumerate(row):
                if tile <= 0:
                    continue
                if tile == 1:
                    img: Surface = transform.scale(
                        dirt_img,
                        (
                            TILE_SIZE,
                            TILE_SIZE
                        )
                    )
                if tile == 2:
                    img: Surface = transform.scale(
                        grass_img,
                        (
                            TILE_SIZE,
                            TILE_SIZE
                        )
                    )
                if tile == 3:
                    blob: Enemy = Enemy(
                        col_count * TILE_SIZE,
                        row_count * TILE_SIZE + 15
                    )
                    blob_group.add(blob)
                    continue
                if tile == 6:
                    lava: Lava = Lava(
                        col_count * TILE_SIZE,
                        row_count * TILE_SIZE + (TILE_SIZE // 2)
                    )
                    lava_group.add(lava)
                    continue
                if tile == 7:
                    coin: Coin = Coin(
                        col_count * TILE_SIZE + (TILE_SIZE // 2),
                        row_count * TILE_SIZE + (TILE_SIZE // 2)
                    )
                    coin_group.add(coin)
                    continue
                if tile == 8:
                    exit_: Exit = Exit(
                        col_count * TILE_SIZE,
                        row_count * int(TILE_SIZE * 0.9)
                    )
                    exit_group.add(exit_)
                    continue
                if img is not None:
                        img_rect: Rect = img.get_rect()
                        img_rect.x = col_count * TILE_SIZE
                        img_rect.y = row_count * TILE_SIZE
                        t: tuple[Surface, Rect] = (
                            img,
                            img_rect
                        )
                        self.tiles.append(
                            t
                        )
    def draw(self) -> None:
        tiles: list = self.tiles
        if not tiles:
                return
        for img_surface, image_rect in tiles:
            scr.blit(
                img_surface,
                image_rect
            )
            """
            draw.rect(
                scr,
                "#ffffff",
                image_rect,
                width=2
            )
            """

# initialize the level
level_data: list[list[int]] = LEVEL_DATA_FALLBACK
try:
    with open(
        f"levels/{level}.txt"
    ) as f:
            level_data = json.load(f)
except (
    OSError,
    json.JSONDecodeError
) as e:
        pass
world: World = World(
    level_data
)

class Button:
    def __init__(
        self,
        x: int,
        y: int,
        image: pg.Surface
    ) -> None:
            self.image: pg.Surface = image
            self.rect: pg.Rect = self.image.get_rect()
            self.rect.x: int = x
            self.rect.y: int = y
            self.clicked: bool = False
            self.needs_reset: bool = False
    def draw(
        self
    ) -> None:
            mouse_pos: tuple[int, int] = pg.mouse.get_pos()
            needs_reset: bool = False
            if self.rect.collidepoint(
                mouse_pos
            ):
                if pg.mouse.get_pressed()[0] == 1\
                    and not self.clicked:
                        self.clicked = True
                        needs_reset = True
            if pg.mouse.get_pressed()[0] == 0:
                self.clicked = False
            (
                image,
                rect
            ) = (
                self.image,
                self.rect
            )
            scr.blit(
                image,
                rect
            )
            return needs_reset

class Player:
    def __init__(
        self,
        *args,
        **kwargs
    ) -> None:
            self.reset(
                *args,
                **kwargs
            )
    def reset(
        self,
        x: int = 100,
        y: int = H - 130
    ) -> None:
            if not isinstance(
                x,
                int
            ):
                x = 0
            if not isinstance(
                y,
                int
            ):
                    y = 0
            self.images_left: list[Surface] = []
            self.images_right: list[Surface] = []
            self.index: int = 0
            self.counter: int = 0
            for n in range(1, 21):
                img_right: Surface = image.load(
                    f"img/girl{n}.png"
                )
                img_right = transform.scale(
                    img_right,
                    (
                        40,
                        60
                    )
                )
                img_left: Surface = transform.flip(
                    img_right,
                    True,
                    False
                )
                self\
                    .images_right\
                    .append(
                        img_right
                    )
                self\
                      .images_left\
                      .append(
                          img_left  
                      )
            self.image: Surface = self.images_right[
                self.index
            ]
            self.rect: Rect = self.image.get_rect()
            self.rect.x: int | float = x
            self.rect.y: int | float = y
            self.ghost_image: Surface = pg.transform.scale(
                pg.image.load("img/ghost.png"),
                (
                    40,
                    60
                )
            )
            self.ghost_rect: Rect = self.image.get_rect()
            self.ghost_rect.x: int | float = x + 5
            self.ghost_rect.y: int | float = y + 20
            self.width: int | float = self.image.get_width()
            self.height: int | float = self.image.get_height()
            self.vel_y: int | float = 0
            self.jumped: bool = False
            self.direction: int = 0
            self.in_air: bool = True
    def update(
        self
    ) -> None:
            global game_over
            if not game_over:
                key: pg.key.ScancodeWrapper = pg\
                    .key\
                    .get_pressed()
                dx: int = 0
                dy: int = 0
                walk_cooldown: int = 1
                if key[K_LEFT]:
                    dx -= 5
                    self.counter +=1
                    self.direction = -1
                elif key[K_RIGHT]:
                    dx += 5
                    self.counter += 1
                    self.direction = 1
                else:
                    self.counter = 0
                    self.index = 0
                    if self.direction == 1:
                        self.image = self.images_right[
                            self.index
                        ]
                    elif self.direction == -1:
                        self.image = self.images_left[
                            self.index
                        ]
                if key[K_UP]\
                   and not any(
                       [
                           self.jumped,
                           self.in_air
                        ]
                    ):
                            self.vel_y = -15
                            self.jumped = True
                else:
                    self.jumped = False
                if key[K_DOWN]:
                    self.vel_y = 30
                # handle animation
                if self.counter > walk_cooldown:
                    self.counter = 0
                    self.index += 1
                    if not 0 <= self.index <\
                        len(
                            self.images_right
                        ):
                            self.index = 0
                    if self.direction == 1:
                        self.image = self.images_right[
                            self.index
                        ]
                    elif self.direction == -1:
                        self.image = self.images_left[
                            self.index
                        ]
                # add gravity
                self.vel_y += 1
                if self.vel_y > 10:
                    self.vel_y = 10
                dy += self.vel_y
                self.in_air = True
                # check for collision
                for _, tile_rect in world.tiles:
                    # horizontal collision
                    if tile_rect.colliderect(
                            self.rect.x + dx,
                            self.rect.y,
                            self.width,
                            self.height
                    ):
                            dx = 0
                    # vertical collision
                    if tile_rect.colliderect(
                        self.rect.x,
                        self.rect.y + dy,
                        self.width,
                        self.height
                    ):
                            if self.vel_y < 0:
                                # if jumping
                                dy = tile_rect.bottom -\
                                     self.rect.top
                                # the distance between
                                # the rect
                                # and the player;
                                # move only the
                                # amount it can
                                # if about
                                # to collide
                            else:
                                # if falling
                                dy = tile_rect.top -\
                                     self.rect.bottom
                            self.vel_y = 0
                            self.in_air = False
                # check for
                # collision with
                # enemies
                if pg.sprite.spritecollide(
                    self,
                    blob_group,
                    False
                ):
                        game_over = 1
                # check for
                # collision with
                # lava
                if pg.sprite.spritecollide(
                    self,
                    lava_group,
                    False
                ):
                        game_over = 1
                # check for
                # collision with
                # exits
                if pg.sprite.spritecollide(
                    self,
                    exit_group,
                    False
                ):
                        game_over = 2
                # update position
                self.rect.x += dx
                self.rect.y += dy
            else:
                self.image = self.ghost_image
                if not self.rect.y < 53:
                    self.rect.y -= 5
            (
                image,
                rect
            ) = (
                self.image,
                self.rect
            )
            scr.blit(
                image,
                rect
            )
            """
            draw.rect(
                scr,
                "#ffffff",
                rect,
                width=2
            )
            """
            
player: Player = Player()

def draw_text(
    text: str,
    font: str,
    text_color: str,
    x: int,
    y: int
) -> None:
        img: pg.Surface = font.render(
            text,
            True,
            text_color
        )
        scr.blit(
            img,
            (
                x,
                y
            )
        )
# handle level change
def set_level(
    level: int
) -> list[list[int]]:
        player.reset()
        blob_group.empty()
        lava_group.empty()
        exit_group.empty()
        level_data: list[list[int]] = LEVEL_DATA_FALLBACK
        try:
            with open(
                f"levels/{level}.txt"
            ) as f:
                    level_data = json.load(f)
        except (
            OSError,
            json.JSONDecodeError
        ) as e:
                pass
        new_world: World = World(
            level_data
        )
        return new_world

# create buttons
restart_button: Button = Button(
    W // 2 - 50,
    H // 2 + 50,
    restart_img
)
start_button: Button = Button(
    W // 2 - 350,
    H // 2,
    start_img
)
exit_button: Button = Button(
    W // 2 + 150,
    H // 2,
    exit_img
)

running: bool = True
while running:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            running = False
    scr.blit(
        bg_img,
        (
            0,
            0
        )
    )
    scr.blit(
        sun_img,
        (
            300,
            50
        )
    )
    if is_main_menu:
        if exit_button.draw():
            running = False
        if start_button.draw():
            is_main_menu = False
    else:
        world.draw()
        if game_over == 0:
            blob_group.update()
            # check if a
            # coin has
            # been collected
            if pg.sprite.spritecollide(
                player,
                coin_group,
                True
            ):
                    score += 1
            draw_text(
                f" {score}",
                SCORE_FONT,
                "#eeee00",
                TILE_SIZE - 10,
                12
            )
        elif game_over == 2:
            # finished a level
            level += 1
            if level > MAX_LEVELS:
                # user won
                # all levels,
                # restart from
                # bare beginnings
                draw_text(
                    f"YOU WIN!",
                    FONT,
                    "#eeee00",
                    W // 2 - 120,
                    H // 2.2
                )
                if restart_button.draw():
                    level = 1
                    world_data = []
                    world = set_level(level)
                    game_over = 0
                    score = 0
            else:
                # update level
                draw_text(
                    f"Level {level}",
                    FONT,
                    "#eeee00",
                    W // 2 - 120,
                    H // 2.2
                )
                world_data = []
                world = set_level(level)
                game_over = 0
        else:
            # lost
            draw_text(
                f"YOU LOSE",
                FONT,
                "#bb0000",
                W // 2 - 120,
                H // 2.2
            )
            if player.rect.y < 53:
                if restart_button.draw():
                    world_data = []
                    world = set_level(level)
                    game_over = 0
                    score = 0
        blob_group.draw(scr)
        lava_group.draw(scr)
        exit_group.draw(scr)
        coin_group.draw(scr)
        player.update()
    clock.tick(FPS)
    display.update()
pg.quit()
raise SystemExit
