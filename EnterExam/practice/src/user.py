def login(username, password):
    users = {
        "Anton": "123456",
        "Maria": "654321"
    }

    if username in users:
        if users[username] == password:
            return True

    return False