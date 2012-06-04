Set objShell = CreateObject("Wscript.Shell")
ryanhome=objShell.ExpandEnvironmentStrings("%RYANHOME%") 
strSoundFile =ryanhome & "\bin\snd\notpass.wav"

strCommand = "sndrec32 /play /close " & chr(34) & strSoundFile & chr(34)

objShell.Run strCommand, 0, True

