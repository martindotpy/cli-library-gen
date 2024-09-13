# CLI Library Gen

CLI Library Gen es una librería que brinda herramientas para crear interfaces de
comandos escritos con Java.

## Description

La idea principal de esta librería es facilitar la creación de interfaces de
comandos en Java. Para ello, se proveen herramientas para definir sub comandos y
flags de manera sencilla. Además, para facilitar su fácil uso, se sigue una
estructura similar a la de
[GNU Coreutils](https://www.gnu.org/software/coreutils/).

Estos argumentos generados seguirán la siguiente estructura:

```bash
<project-name> <optional-sub-command> --<flag> <arg1> <arg2> ... <argN>
```

or

```bash
<project-name> <optional-sub-command> -<short-flag> <arg1> <arg2> ... <argN>
```

## To-do

- [x] Implementar funcionalidad de flag
- [ ] Implementar funcionalidad de sub comandos
- [ ] Implementar una parses de los sub comandos, flags y argumentos
- [ ] Implementar un manage para todos los sub comandos y flags
- [ ] Implementar testing

## Anexos

- [Documentación del proyecto](https://docs.google.com/document/d/1J68LCDewLswLGXYSNAZNQ1PjGhjsjVJcZz7b_H0TazQ/edit)
