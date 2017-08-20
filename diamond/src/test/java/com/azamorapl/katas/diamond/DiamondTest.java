package com.azamorapl.katas.diamond;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DiamondTest {
    @Test
    public void printDiamond(){
        DiamondPrinter d = new DiamondPrinter();
        assertThat(d.print('A'),is("A"));
        assertThat(d.print('B'),is(
                        " A \n"+
                        "B B\n"+
                        " A "));
        assertThat(d.print('C'),is(
                        "  A  \n"+
                        " B B \n"+
                        "C   C\n"+
                        " B B \n"+
                        "  A  "));
        assertThat(d.print('H'),is(
                        "       A       \n"+
                        "      B B      \n"+
                        "     C   C     \n"+
                        "    D     D    \n"+
                        "   E       E   \n"+
                        "  F         F  \n"+
                        " G           G \n"+
                        "H             H\n"+
                        " G           G \n"+
                        "  F         F  \n"+
                        "   E       E   \n"+
                        "    D     D    \n"+
                        "     C   C     \n"+
                        "      B B      \n"+
                        "       A       "));
        assertThat(d.print('Z'),is(
                        "                         A                         \n"+
                        "                        B B                        \n"+
                        "                       C   C                       \n"+
                        "                      D     D                      \n"+
                        "                     E       E                     \n"+
                        "                    F         F                    \n"+
                        "                   G           G                   \n"+
                        "                  H             H                  \n"+
                        "                 I               I                 \n"+
                        "                J                 J                \n"+
                        "               K                   K               \n"+
                        "              L                     L              \n"+
                        "             M                       M             \n"+
                        "            N                         N            \n"+
                        "           O                           O           \n"+
                        "          P                             P          \n"+
                        "         Q                               Q         \n"+
                        "        R                                 R        \n"+
                        "       S                                   S       \n"+
                        "      T                                     T      \n"+
                        "     U                                       U     \n"+
                        "    V                                         V    \n"+
                        "   W                                           W   \n"+
                        "  X                                             X  \n"+
                        " Y                                               Y \n"+
                        "Z                                                 Z\n"+
                        " Y                                               Y \n"+
                        "  X                                             X  \n"+
                        "   W                                           W   \n"+
                        "    V                                         V    \n"+
                        "     U                                       U     \n"+
                        "      T                                     T      \n"+
                        "       S                                   S       \n"+
                        "        R                                 R        \n"+
                        "         Q                               Q         \n"+
                        "          P                             P          \n"+
                        "           O                           O           \n"+
                        "            N                         N            \n"+
                        "             M                       M             \n"+
                        "              L                     L              \n"+
                        "               K                   K               \n"+
                        "                J                 J                \n"+
                        "                 I               I                 \n"+
                        "                  H             H                  \n"+
                        "                   G           G                   \n"+
                        "                    F         F                    \n"+
                        "                     E       E                     \n"+
                        "                      D     D                      \n"+
                        "                       C   C                       \n"+
                        "                        B B                        \n"+
                        "                         A                         "));
    }
}