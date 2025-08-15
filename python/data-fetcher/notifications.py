import smtplib
from email.mime.text import MIMEText

def send_email(subject, body, to_email):
    msg = MIMEText(body, "plain")
    msg["Subject"] = subject
    msg["From"] = "your_email@example.com"
    msg["To"] = to_email

    with smtplib.SMTP("smtp.gmail.com", 587) as smtp:
        smtp.starttls()
        smtp.login("your_email@example.com", "your_app_password")
        smtp.send_message(msg)
