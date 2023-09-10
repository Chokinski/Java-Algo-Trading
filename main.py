from tkinter import *

root = Tk()
root.title('HI BUTTON')
root.geometry('500x500') 

button = Button(root, text='CLICK :):)', command= 'HI')
button.pack()

btnOne = Button(root, text="Click this!", bd='4',
                command = root.destroy)
btnOne.pack(side= 'top')

root.mainloop()
