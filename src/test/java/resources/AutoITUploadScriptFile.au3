
; control id = class + instance


;take file path from command line


;1st paramter
$filepath = $CmdLine[1]

;MsgBox( 1, "title",  $filepath)


ControlFocus("Open","","Edit1")
ControlSetText("Open","","Edit1", $filepath)
ControlClick("Open", "", "Button1")

;ControlSetText("Open","","Edit1","D:\temp\autoITupload.txt")