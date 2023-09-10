from tkinter import *

root = Tk()
root.title('HI BUTTON')
root.geometry('500x500') 

label = Label(root, text='HI')
label.pack(y=30)

btnOne = Button(root, text="Click this!", bd='4',
                command = )
btnOne.pack(side= 'top')

root.mainloop()
