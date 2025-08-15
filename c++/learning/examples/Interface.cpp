#include <QApplication>
#include <QPushButton>
#include <QVBoxLayout>
#include <QLabel>
#include <QWidget>

class ClickCounter : public QWidget {
    Q_OBJECT
private:
    int count = 0;
    QLabel *label;

public:
    ClickCounter() {
        QVBoxLayout *layout = new QVBoxLayout(this);
        label = new QLabel("Clicks: 0");
        QPushButton *button = new QPushButton("Click Me");

        layout->addWidget(label);
        layout->addWidget(button);

        connect(button, &QPushButton::clicked, this, &ClickCounter::incrementCount);
    }

private slots:
    void incrementCount() {
        count++;
        label->setText("Clicks: " + QString::number(count));
    }
};

int main(int argc, char *argv[]) {
    QApplication app(argc, argv);

    ClickCounter window;
    window.show();

    return app.exec();
}

#include "main.moc"
