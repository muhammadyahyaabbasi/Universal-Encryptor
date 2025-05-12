# Universal Encryptor: A Multimedia Encryption & Decryption Tool in Java

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/your-username/UniversalEncryptor/graphs/commit-activity)
[![Java](https://img.shields.io/badge/Java-11+-blue.svg)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-11+-orange.svg)](https://openjfx.io/)

## Description

**Universal Encryptor** is a Java-based desktop application designed to securely encrypt and decrypt various types of data, including text, common file formats, images, audio, and video. It provides a user-friendly graphical interface built with JavaFX, allowing users to easily protect their sensitive information. The application leverages robust encryption algorithms like AES and RSA to ensure data confidentiality.

**Key Features:**

* **Versatile Data Support:** Encrypt and decrypt text, documents (PDF, DOCX), images (JPG, PNG), audio files (MP3, WAV), and video files (MP4, AVI).
* **Multiple Encryption Algorithms:** Offers a choice of strong encryption algorithms, including:
    * **AES (Advanced Encryption Standard):** A widely trusted symmetric encryption algorithm suitable for all data types.
    * **RSA:** An asymmetric encryption algorithm ideal for smaller text and secure key exchange.
    * **Base64 Encoding (Optional):** For basic encoding and decoding purposes.
* **Intuitive Graphical User Interface (GUI):** A user-friendly interface built with JavaFX, making encryption and decryption processes straightforward for users of all technical levels.
* **Easy File Handling:** Features a file chooser for simple input file selection and options to save the encrypted/decrypted output.
* **Algorithm Selection:** Users can choose the desired encryption algorithm via a dropdown menu.
* **Real-time Operation Feedback:** A dedicated log area displays the status of encryption and decryption processes.
* **Text and Image Preview:** Provides a display area to preview text content or loaded images before and after encryption/decryption (where applicable).

## Installation

1.  **Prerequisites:**
    * **Java Development Kit (JDK) 11 or later:** Ensure you have a compatible JDK installed on your system. You can download it from [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.java.net/).
    * **JavaFX SDK 11 or later:** If it's not bundled with your JDK, download the JavaFX SDK from [OpenJFX](https://openjfx.io/downloads/). You might need to configure your IDE to include the JavaFX modules.

2.  **Download:**
    * You can download the latest compiled release (if available) from the [Releases](https://github.com/your-username/UniversalEncryptor/releases) page.

3.  **Running the Application:**
    * **If you downloaded a compiled JAR:** Open your terminal or command prompt, navigate to the directory containing the JAR file, and run:
        ```bash
        java --module-path /path/to/javafx-sdk-11/lib --add-modules javafx.controls,javafx.fxml -jar UniversalEncryptor.jar
        ```
        *(Replace `/path/to/javafx-sdk-11/lib` with the actual path to your JavaFX SDK `lib` folder.)*
    * **If running from source (e.g., in an IDE):** Ensure your project is properly set up with the JavaFX SDK linked, and run the `MainApplication.java` file.

## Usage

1.  Launch the Universal Encryptor application.
2.  **Select Operation:** Choose whether you want to "Encrypt" or "Decrypt" using the appropriate section of the GUI.
3.  **Input:**
    * **For Text:** Enter or paste the text into the provided text area.
    * **For Files/Images/Audio/Video:** Click the "Browse" button to select the file you want to process.
4.  **Algorithm:** Choose the desired encryption algorithm (AES, RSA, Base64) from the dropdown menu.
5.  **Key/Password (if applicable):** Depending on the chosen algorithm, you might need to enter an encryption/decryption key or password. **Remember to keep your key secure!**
6.  **Output:**
    * **For Text:** The encrypted/decrypted text will be displayed in the output text area. You can then copy or save it.
    * **For Files/Images/Audio/Video:** Click the "Save" button and choose the desired location and filename for the output file.
7.  Click the "Encrypt" or "Decrypt" button to start the process.
8.  Monitor the "Logs" area for the status of the operation.

## Tech Stack

* **Java (JDK 11+)**
* **JavaFX (11+)**
* **Java Cryptography Extension (JCE)**
* **Optional Libraries:**
    * **Apache Commons Codec:** For Base64 encoding/decoding.
    * **JCodec / Xuggler:** For more advanced handling of audio and video files.
    * **TarsosDSP:** For potential advanced audio processing.

## Modules Breakdown

* **`core/encryption/`**: Contains classes for different encryption algorithms (AES, RSA, Base64).
* **`core/util/`**: Utility classes for file operations and other common tasks.
* **`gui/`**: Contains the JavaFX GUI controller (`GUIController.java`), the main application class (`MainApplication.java`), and the FXML layout (`MainScene.fxml`).
* **`modules/`**: Contains specific encryptor/decryptor classes for different data types:
    * `TextEncryptor.java`: Handles text encryption and decryption.
    * `FileEncryptor.java`: Handles encryption and decryption of generic files.
    * `ImageEncryptor.java`: Handles image-specific encryption and decryption (including potential preview).
    * `AudioEncryptor.java`: Handles audio file encryption and decryption.
    * `VideoEncryptor.java`: Handles video file encryption and decryption.

## Optional Features (Planned or Potential)

* Password-protected encryption for enhanced security.
* Drag-and-drop functionality for easy file selection.
* Dark mode user interface theme.
* File size limitations and alerts for large files.
* More advanced encryption algorithm options.

## Contributing

Contributions to this project are welcome! If you have any suggestions, bug reports, or would like to contribute code, please follow these steps:

1.  Fork the repository on GitHub.
2.  Create a new branch for your changes (`git checkout -b feature/your-feature-name`).
3.  Make your changes and commit them (`git commit -am 'Add some feature'`).
4.  Push to the branch on GitHub (`git push origin feature/your-feature-name`).
5.  Submit a pull request.

Please ensure your code adheres to the project's coding standards and includes appropriate comments.

## License

This project is licensed under the [MIT License](LICENSE). See the `LICENSE` file for more information.

## Author

Muhammad Yayha



