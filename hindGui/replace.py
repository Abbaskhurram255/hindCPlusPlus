import os

def replace_text_in_files(directory_path, old_text, new_text, file_extension=None):
    """
    Replaces occurrences of old_text with new_text in all files within a directory.

    Args:
        directory_path (str): The path to the directory containing the files.
        old_text (str): The text to be replaced.
        new_text (str): The text to replace old_text with.
        file_extension (str, optional): If provided, only files with this extension
                                        (e.g., '.txt', '.py') will be processed.
                                        Defaults to None, processing all files.
    """
    for root, _, files in os.walk(directory_path):
        for filename in files:
            if file_extension and not filename.endswith(file_extension):
                continue

            filepath = os.path.join(root, filename)
            try:
                with open(filepath, 'r', encoding='utf-8') as file:
                    content = file.read()

                if old_text in content:
                    modified_content = content.replace(old_text, new_text)
                    with open(filepath, 'w', encoding='utf-8') as file:
                        file.write(modified_content)
                    print(f"Text replaced in: {filepath}")
                else:
                    print(f"'{old_text}' not found in: {filepath}")

            except Exception as e:
                print(f"Error processing {filepath}: {e}")

if __name__ == "__main__":
    target_directory = r"C:\Users\Adi\Documents\GitHub\hindCPlusPlus\hindGui"
    text_to_find = "enable_events=False"
    replacement_text = "enable_events=True"
    extension_filter = ".py"

    replace_text_in_files(target_directory, text_to_find, replacement_text, extension_filter)
    print("\nReplacement process complete.")
