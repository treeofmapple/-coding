#include <iostream>
#include <fstream>
#include <thread>
#include <mutex>
#include <chrono>

std::mutex fileMutex;

// Function to write data to a file
void writeToFile(const std::string& filename) {
    std::lock_guard<std::mutex> lock(fileMutex); // Prevent race conditions
    std::ofstream outFile(filename, std::ios::app);
    if (outFile.is_open()) {
        outFile << "Hello from thread " << std::this_thread::get_id() << "\n";
        std::cout << "Data written to file.\n";
    }
}

// Function to read data from a file
void readFromFile(const std::string& filename) {
    std::this_thread::sleep_for(std::chrono::milliseconds(50)); // Simulate delay
    std::lock_guard<std::mutex> lock(fileMutex);
    std::ifstream inFile(filename);
    std::string line;
    if (inFile.is_open()) {
        std::cout << "File contents:\n";
        while (getline(inFile, line)) {
            std::cout << line << "\n";
        }
    }
}

int main() {
    std::string filename = "example.txt";

    std::thread writer1(writeToFile, filename);
    std::thread writer2(writeToFile, filename);
    std::thread reader(readFromFile, filename);

    writer1.join();
    writer2.join();
    reader.join();

    return 0;
}
