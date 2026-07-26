import tkinter as tk
from tkinter import ttk
from DBInit import *
from DBCommands import *
from datetime import *

# Creating root
root = tk.Tk()
root.title('GeoPoint')

# Creating window
frm = ttk.Frame(root, padding=10)
frm.grid()

# Intro text
intro_label = ttk.Label(frm, text="Welcome to my birthday tracker program!")

# Getting first name
name_label = ttk.Label(frm, text='First Name')
name_var = tk.StringVar()
name_txt = ttk.Entry(frm, text=name_var)

# Showing date
date_label = ttk.Label(frm, text=datetime.now().strftime("%x"))

# Getting last name
last_label = ttk.Label(frm, text='Last Name')
last_var = tk.StringVar()
last_txt = ttk.Entry(frm, text=last_var)

# Whose birthday label
who_label = ttk.Label(frm, text='Birthdays today:')

# Getting birthday
birthday_label = ttk.Label(frm, text='Birthday')
birthday_var = tk.StringVar()
birthday_txt = ttk.Entry(frm, text=birthday_var)

# Todays birthday box
todays_bd_txt = tk.Text(frm, height=1, width=12)
todays_bd_txt.insert(tk.END, get_todays_birthdays())

# Creating text display box
text_box = tk.Text(frm, height=10, width=60)
text_box.insert(tk.END, get_birthdays())

# Defining submit function
def submit():
    user_name = name_var.get()
    user_last = last_var.get()
    user_birthday = birthday_var.get()
    commit((user_name, user_last, user_birthday))
    text_box.delete("1.0", tk.END)
    text_box.insert(tk.END, get_birthdays())

def clear_text():
    name_txt.delete(0, tk.END)
    last_txt.delete(0, tk.END)
    birthday_txt.delete(0, tk.END)

# Creating submit button
submit_btn = ttk.Button(frm, text='Submit', command=submit)

# Creating a clear text button
clear_btn = ttk.Button(frm, text='Clear', command=clear_text)

# Creating quit button
quit_btn = ttk.Button(frm, text="Quit", command=root.destroy)

# Positioning buttons, labels, and text fields
intro_label.grid(column=2, row=0)
name_label.grid(column=1, row=2)
name_txt.grid(column=2, row=2)
date_label.grid(column=3, row=2)
last_label.grid(column=1, row=3)
last_txt.grid(column=2, row=3)
who_label.grid(column=3, row=3)
birthday_label.grid(column=1, row=4)
birthday_txt.grid(column=2, row=4)
todays_bd_txt.grid(column=3, row=4)
submit_btn.grid(column=1, row=5)
clear_btn.grid(column=2, row=5)
quit_btn.grid(column=3, row=5)
text_box.grid(column=1, row=6, columnspan=3)

# Starting mainloop
root.mainloop()