import sqlite3
from datetime import *


# Defining get birthdays
def get_birthdays():
    conn = sqlite3.connect('Birthdays.db')
    curs = conn.cursor()

    select_command = '''
        SELECT * FROM BirthdaysTbl
    '''

    curs.execute(select_command)
    birthdays_data = curs.fetchall()

    conn.commit()
    conn.close()
    return birthdays_data

# Defining commit to commit birthdays to the database
def commit(birthday):
    if birthday not in get_birthdays():
        conn = sqlite3.connect('Birthdays.db')
        curs = conn.cursor()

        insert_command = '''
            INSERT INTO BirthdaysTbl(FirstName, LastName, Birthday)
            VALUES(?,?,?)
        '''
        curs.execute(insert_command, birthday)

        conn.commit()
        conn.close()

# Defining get todays birthdays
def get_todays_birthdays():
    todays_birthdays = []
    today = datetime.now().strftime("%x")
    for birthday in get_birthdays():
        if birthday[2] == today[:5]:
            todays_birthdays.append(birthday[:1])
    return todays_birthdays