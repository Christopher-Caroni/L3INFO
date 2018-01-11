#bin/bash

valeurAttribut="(\"[[:alnum:]]*\")|(\"&$refEntite\")"
nomXML="([[:alpha:]]|_|:)([[:alnum:]]|_|:|\.|-)*"
refEntite="&\w*;"
baliseOuvrante="<$nomXML[[:space:]]$nomXML[[:space:]]?\=[[:space:]]?($valeurAttribut[[:space:]]?)*>"

echo -e "\n** Q1 :\n"
egrep --color=auto -m 10 "$valeurAttribut" html/*

echo -e "\n** Q2 :\n"
egrep --color=auto -m 10 "$baliseOuvrante" html/*

echo -e "\n** Q3 :\n"
egrep --color=auto -o "(([0-9]{2}\.){4}[0-9]{2})|(\+33\s\(0\)\s[0-9]\.(([0-9]{2}\.){3}[0-9]{2}))" html/*
