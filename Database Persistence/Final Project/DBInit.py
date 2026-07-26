import sqlite3

# Creating database
conn = sqlite3.connect('Birthdays.db')
curs = conn.cursor()

# Creating Table
create_command = '''
CREATE TABLE BirthdaysTbl(
    FirstName TEXT,
    LastName TEXT,
    Birthday TEXT
)'''

# Only creating table if there isn't already one by the same name
try:
    curs.execute(create_command)
except:
    pass

# Committing and closing
conn.commit()
conn.close()