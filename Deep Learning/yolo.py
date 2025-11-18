from ultralytics import YOLO
from cv2 import VideoCapture, imshow, waitKey, resize, destroyAllWindows
from collections import Counter
model = YOLO("yolov8n.pt")


capturer = VideoCapture("test.mp4")
def check_for_label(result_list: list, target_label_name: str):
        for result in result_list:
            class_names = result.names
            for box in result.boxes:
                class_id = int(box.cls[0])
                detected_label = class_names[class_id]
                if detected_label == target_label_name:
                    return True
        return False
def get_occurences(result_list: list, of: str = None):
    for result in result_list:
        class_ids = result.boxes.cls.tolist() 
        counts = Counter(class_ids) 
        class_names = model.names
        named_counts = {class_names[class_id]: count for class_id, count in counts.items()}
        of = str(of).strip()
        if not of or not of in named_counts:
            return named_counts
        return named_counts[of]
    
while capturer.isOpened():
    ret, frame = capturer.read()
    if not ret:
        break
    results = model(frame)
    annotated_frame = results[0].plot()
    resized_frame = resize(annotated_frame, (640, 480))
    imshow("Test Capture Session", resized_frame)
    is_car_detected = check_for_label(results, 'car')
    number_of_cars_detected = get_occurences(results, "car")
    print(f"Is a 'car' detected? {is_car_detected}")
    print(f"How many? {number_of_cars_detected} cars")
    if waitKey(1) & 0xFF == 27:
        break
capturer.release()
destroyAllWindows()
