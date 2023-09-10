from tkinter import *

def showText():
    global txtState
    if txtState == False:
        label.pack()
        btnOne.pack_forget()
        btnTwo.pack(side ='bottom')
    txtState = True

def hideText():
    global txtState
    if txtState == True:
        label.pack_forget()
        btnTwo.pack_forget()
        btnOne.pack(side= 'top')
    txtState = False


def main():
    global txtState
    global btnOne
    global btnTwo
    global label
    root = Tk()
    root.title('HI BUTTON')
    root.geometry('500x500') 
    label = Label(root, text="Hi")
    

    txtState = False
    btnOne = Button(root,justify='center', text="Show this!", bd='2',
                    command = lambda: showText())

    btnTwo = Button(root,justify='center', text="Hide this!", bd='4',
                    command = lambda: hideText())
    btnOne.pack(side= 'top')

    root.mainloop()
main()
