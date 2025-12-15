import hindGui
from hindGui import Column, VPush, Push

def Center(one_column_layout_list: list) -> list[list]:
    # ##################################################
    # __________________________________________________
    # @PARAM
    #    one_column_layout_list<list>:
    #        the one-column layout list --- in the form of
    #        LIST OF ROWS (of elements) --- to center
    #    
    # 
    # __________________________________________________
    # @RETURN
    #    TYPE:
    #        list[list]
    #    DESCRIPTION: accepts a list of sub-lists (rows)
    #        containing Elements (with a capital E),
    #        BUT returns a 2D list
    # __________________________________________________
    # ##################################################
    if one_column_layout_list is None or len(one_column_layout_list) == 0 or not isinstance(one_column_layout_list, list) or one_column_layout_list[0] is None:
        return [[]]
    return [
        [VPush()],
        [Push(), Column(one_column_layout_list, element_justification="center"), Push()],
        [VPush()]
    ]
def HCenter(one_column_layout_list: list) -> list[list]:
    # NOTE: accept a list, but returns a 2D list
    if one_column_layout_list is None or len(one_column_layout_list) == 0 or not isinstance(one_column_layout_list, list) or one_column_layout_list[0] is None:
        return []
    return [
        [Push(), Column(one_column_layout_list, element_justification="center"), Push()]
    ]
def VCenter(one_column_layout_list: list) -> list[list]:
    # NOTE: accept a list, but returns a 2D list
    if one_column_layout_list is None or len(one_column_layout_list) == 0 or not isinstance(one_column_layout_list, list) or one_column_layout_list[0] is None:
        return []
    return [
        [VPush()],
        [Column(one_column_layout_list)],
        [VPush()]
    ]
