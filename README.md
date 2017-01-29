# farium
Sets the clipboard contents via deep link on android.

Spaces in the text need to be escaped. This is so terminal/bash/etc. won't strip the quotes out of
the command and not send the command correctly to adb.

# Example usage:
`adb shell am broadcast -a clippy -e "t" "text\ goes\ here"`
