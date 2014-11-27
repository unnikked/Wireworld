# Wireworld

[Wireworld](http://en.wikipedia.org/wiki/Wireworld) is a cellular automaton first proposed by Brian Silverman in 1987. It is particularly suited to simulating electronic logic elements, or "gates", and, despite the simplicity of the rules, Wireworld is [Turing-complete](http://en.wikipedia.org/wiki/Turing-complete).

## Rules
A Wireworld cell can be in one of four different states, usually numbered 0–3 in software, modeled by colors in the examples here:

0. Empty (Black)
1. Electron head (Blue)
2. Electron tail (Red)
3. Conductor (Yellow)

As in all cellular automata, time proceeds in discrete steps called generations (sometimes "gens" or "ticks").

Cells behave as follows:

- Empty → Empty
- Electron head → Electron tail
- Electron tail → Conductor
- Conductor → Electron head if exactly one or two of the neighbouring cells are electron heads, or remains Conductor otherwise.

### How to use it
With your mouse you can add Conductors by left-clicking on the grid (click again on a conductor to erase it), by righ-clicking you change the state of the grid respectively to Electron head, Electron tail and Conductor cyclically.

By pressing `enter` you will manually compute a tick of the current generation.

By pressing `space` you will start to compute next generations manually.

By pressing numbers from `1` to `0` on your keyboard you can set ten different speed to the simulation.

By pressing `?` you will see instructions.

### Screenshots

![Main View](http://i.imgur.com/e8I5LcQ.png)

An example of the *world*. A `xor` gate and two clock generator.

![Export View](http://i.imgur.com/Ski5XSF.png)

Basic export dialog. 

![Import View](http://i.imgur.com/adErRFu.png)

Basic import dialog.

# To Do
- ~~Import export function~~
- More customization on user interface
- ~~Mouse drag support~~