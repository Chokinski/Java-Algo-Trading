from tkinter import *

root = Tk()
root.title('HI BUTTON')
root.geometry('1000x1000') 

button = Button(root, text='CLICK :):)', command= 'HI')
button.pack()

root.mainloop()
