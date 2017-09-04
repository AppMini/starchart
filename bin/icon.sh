#!/bin/sh

color="#1BE3C6"

font-awesome-svg-png --nopadding --sizes 192 --color "$color" --icons star --png --dest .
mv "$color/png/192/star.png" public/icon.png
rm -rf "$color"
