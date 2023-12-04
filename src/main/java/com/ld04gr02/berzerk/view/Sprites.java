package com.ld04gr02.berzerk.view;

public class Sprites {

    public static int getStickManWidth() {
        return 8;
    }

    public static int getStickManHeight() {
        return 16;
    }
    private static final String[] STICKMAN_MOVING_LEFT = {
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
    public static String[] getStickManMovingLeft() {
        return STICKMAN_MOVING_LEFT;
    }
    private static final String[] STICKMAN_MOVING_RIGHT = {
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
    public static String[] getStickManMovingRight() {
        return STICKMAN_MOVING_RIGHT;
    }

    private static final String[] STICKMAN_RIGHT = {
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
    public static String[] getStickManRight() {
        return STICKMAN_RIGHT;
    }
    private static final String[] STICKMAN_LEFT = {
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
    public static String[] getStickManLeft() {
        return STICKMAN_LEFT;
    }

    public static int getRobotWidth() {
        return 13;
    }

    public static int getRobotHeight() {
        return 13;
    }

    private static final String[] ROBOT = {
            "   #######",
            " ####   ####",
            "####     ####",
            "## ####### ##",
            "## ####### ##",
            "## ####### ##",
            "## ####### ##",
            "   #######",
            "   ##   ##",
            "   ##   ##",
            "   ##   ##",
            "   ##   ##",
            "  ###   ###"
    };
    public static String[] getRobot() {
        return ROBOT;
    }

    private static final String[] BULLET = {
            "####",
    };

    public static String[] getBullet() {
        return BULLET;
    }

    public static int getBulletWidth() {
        return 5;
    }

    public static int getBulletHeight() {
        return 1;
    }

    private static final String[] LOGO = {
            "██████╗ ███████╗██████╗ ███████╗███████╗██████╗ ██╗  ██╗",
            "██╔══██╗██╔════╝██╔══██╗╚══███╔╝██╔════╝██╔══██╗██║ ██╔╝",
            "██████╔╝█████╗  ██████╔╝  ███╔╝ █████╗  ██████╔╝█████╔╝ ",
            "██╔══██╗██╔══╝  ██╔══██╗ ███╔╝  ██╔══╝  ██╔══██╗██╔═██╗ ",
            "██████╔╝███████╗██║  ██║███████╗███████╗██║  ██║██║  ██╗",
            "╚═════╝ ╚══════╝╚═╝  ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝"
    };
    public static String[] getLogo() {
        return LOGO;
    }
    private static final String[] HEART = {
            "    #####        #####",
            "  #########    #########",
            " ###########  ###########",
            "##########################",
            "##########################",
            "##########################",
            " ########################",
            "  ######################",
            "    ##################",
            "      ##############",
            "        ##########",
            "          ######",
            "            ##"
    };
    public static String[] getHeart() {
        return HEART;
    }

    private static final String[] SCORE = {


            " ###########   ###########    #########    ##########    ########### ",
            "############  ############   ###########  ############  ############ ",
            "############  ############  ############# ############# ############     ",
            "###           ###           ###       ### ###       ### ###              ### ",
            "############  ###           ###       ### ############# ############     ###",
            "############# ###           ###       ### ############# ############",
            " ############ ###           ###       ### ############  ############     ###",
            "          ### ###           ###       ### ###    ###    ###              ###",
            " ############ ############  ############# ###     ###   ############   ",
            " ############ ############   ###########  ###      ###  ############  ",
            " ###########   ###########    #########   ###       ###  ###########    "


    };
    public static String[] getScore() {
        return SCORE;
    }

    private static final String[][] NUMBERS = {
            {

                    "  #########  ",
                    " ########### ",
                    "##█#█#####█##",
                    "######    ###",
                    "### ###   ###",
                    "###  ###  ###",
                    "###   ### ###",
                    "###    ######",
                    "##█#####█#█##",
                    " ########### ",
                    "  #########  "

            },
            {

                    "     ####     ",
                    "   #█#####    ",
                    "  ########    ",
                    "   ## ####    ",
                    "      ####    ",
                    "      ####    ",
                    "      ####    ",
                    "      ####    ",
                    "  ####█##█### ",
                    " #############",
                    "  ########### "
            },
            {

                    "  ########### ",
                    " #############",
                    "  #########█##",
                    "           ###",
                    "           ###",
                    "  #########█##",
                    " #############",
                    " ##█######### ",
                    " ##█######### ",
                    " #############",
                    "  ########### "
            },
            {

                    "  ########### ",
                    " #############",
                    "  #########█##",
                    "           ###",
                    "  #########█##",
                    " #############",
                    "  #########█##",
                    "           ###",
                    "  #########█##",
                    " #############",
                    "  ########### "
            },
            {

                    "  #         # ",
                    " ###       ###",
                    " ###       ###",
                    " ###       ###",
                    " ##█#######█##",
                    " #############",
                    "  #########█##",
                    "           ###",
                    "           ###",
                    "           ###",
                    "            # "
            },
            {

                    "  ###########  ",
                    " ############# ",
                    " ##█#########  ",
                    " ##█#########  ",
                    " ############# ",
                    "  #########█## ",
                    "           ### ",
                    "           ### ",
                    "  #########█## ",
                    " ############# ",
                    "  ###########  "
            },
            {
                    "  ########### ",
                    " #############",
                    " ##█######### ",
                    " ###          ",
                    " ##█######### ",
                    " #############",
                    " ##█#######█##",
                    " ###       ###",
                    " ##█#######█##",
                    " #############",
                    "  ########### "
            },
            {

                    "  ########### ",
                    " #############",
                    "  #########█##",
                    "          ### ",
                    "         ###  ",
                    "        ###   ",
                    "       ###    ",
                    "      ###     ",
                    "     ###      ",
                    "    ###       ",
                    "     #        "
            },

            {

                    "  ########### ",
                    " #############",
                    " ##█#######█##",
                    " ###       ###",
                    " ##█#######█##",
                    "  ########### ",
                    " ##█#######█##",
                    " ###       ###",
                    " ##█#######█##",
                    " #############",
                    "  ########### "
            },
            {

                    "  ########### ",
                    " #############",
                    " ##█#######█##",
                    " ###       ###",
                    " ##█#######█##",
                    " #############",
                    "  #########█##",
                    "           ###",
                    "  #########█##",
                    " #############",
                    "  ########### "
            },

    };
    public static String[] getNumber(int number) {
        return NUMBERS[number];
    }


}











