package com.ld04gr02.berzerk.view;

public class Sprites {

    public static int getStickManWidth() {
        return 8;
    }

    public static int getStickManHeight() {
        return 16;
    }
    public static final String[] STICKMAN_MOVING_LEFT = {
            "   ##",
            "   ##",
            "",
            "  ####",
            "  ### #",
            "  ### #",
            "  ### #",
            " #####",
            "   ##",
            "   ##",
            "  # #",
            " #  #",
            " #  ####",
            " #     #",
            " #",
            "##"
    };
    public static final String[] STICKMAN_MOVING_RIGHT = {
            "   ##",
            "   ##",
            "",
            "  ####",
            " # ###",
            " # ###",
            " # ###",
            "  #####",
            "   ##",
            "   ##",
            "   # #",
            "   #  #",
            "####  #",
            "#     #",
            "      # ",
            "      ##"
    };

    public static final String[] STICKMAN_RIGHT = {
            "   ##",
            "   ##",
            "",
            "  ####",
            " # ## #",
            " # ## #",
            " # ## #",
            " # ## #",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ###",
            "   #"
    };
    public static final String[] STICKMAN_LEFT = {
            "   ##",
            "   ##",
            "",
            "  ####",
            " # ## #",
            " # ## #",
            " # ## #",
            " # ## #",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ###",
            "   #"
    };


    public static int getRobotWidth() {
        return 13;
    }

    public static int getRobotHeight() {
        return 13;
    }

    public static final String[] ROBOT = {
            "   #######",
            " ####   ####",
            "####     ####",
            "## ####### ##",
            "## ####### ##",
            "## ####### ##",
            "## ####### ##",
            "   ######",
            "   ##  ##",
            "   ##  ##",
            "   ##  ##",
            "   ##  ##",
            "  ###  ###"
    };

    public static final String[] LOGO = {
        "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗",
        "██╔══██╗██╔════╝██╔══██╗╚══███╔╝██╔════╝██╔══██╗██║ ██╔╝",
        "██████╔╝█████╗  ██████╔╝  ███╔╝ █████╗  ██████╔╝█████╔╝ ",
        "██╔══██╗██╔══╝  ██╔══██╗ ███╔╝  ██╔══╝  ██╔══██╗██╔═██╗ ",
        "██████╔╝███████╗██║  ██║███████╗███████╗██║  ██║██║  ██╗",
        "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝"
    };
}