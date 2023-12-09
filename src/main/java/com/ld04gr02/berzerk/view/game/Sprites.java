package com.ld04gr02.berzerk.view.game;

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

    private static final String[] STICKMAN_SHOOTING_RIGHT = {
            "   ##",
            "   ##",
            "",
            "   ####",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ###",
    };

    public static String[] getStickManShootingRight() {
        return STICKMAN_SHOOTING_RIGHT;
    }
    private static final String[] STICKMAN_SHOOTING_LEFT = {
            "   ##",
            "   ##",
            "",
            " ####",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "  ###",
    };

    public static String[] getStickManShootingLeft() {
        return STICKMAN_SHOOTING_LEFT;
    }

    private static final String[] STICKMAN_SHOOTING_UP = {
            "   ##",
            "   ##",
            "",
            "   ### #",
            "   ## ##",
            "   ##  #",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "  ###"
    };

    public static String[] getStickManShootingUp() {
        return STICKMAN_SHOOTING_UP;
    }

    private static final String[] STICKMAN_SHOOTING_DOWN = {
            "   ##",
            "   ##",
            "",
            "  ####",
            "  ####",
            "  ### #",
            "  ### #",
            "  ### #",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ##",
            "   ###",
    };

    public static String[] getStickManShootingDown() {
        return STICKMAN_SHOOTING_DOWN;
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


    public static int getEvilSmileWidth() {
        return 12;
    }

    public static int getEvilSmileHeight() {
        return 10;
    }
    private static final String[] EVIL_SMILE = {
            "   ######",
            " ##########",
            "###  ##  ###",
            "############",
            "############",
            "############",
            "############",
            "##  ####  ##",
            " ##      ##",
            "  ########"
    };
    public static String[] getEvilSmile() {
        return EVIL_SMILE;
    }

    private static final String[] HORIZONTAL_BULLET = {
            "###",
    };

    private static final String[] VERTICAL_BULLET = {
            "#",
            "#",
            "#",
    };
    public static String[] getHorizontalBullet() {
        return HORIZONTAL_BULLET;
    }

    public static String[] getVerticalBullet() {
        return VERTICAL_BULLET;
    }

    public static int getBulletLong() {
        return 3;
    }

    public static int getBulletShort() {
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
    public static int getLogoLength() {
        return 56;
    }

    private static final String[] GAMEOVER = {
            " ██████╗  █████╗ ███╗   ███╗███████╗",
            "██╔════╝ ██╔══██╗████╗ ████║██╔════╝",
            "██║  ███╗███████║██╔████╔██║█████╗  ",
            "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  ",
            "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗",
            " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝",
            " ██████╗ ██╗   ██╗███████╗██████╗ ",
            "██╔═══██╗██║   ██║██╔════╝██╔══██╗",
            "██║   ██║██║   ██║█████╗  ██████╔╝",
            "██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗",
            "╚██████╔╝ ╚████╔╝ ███████╗██║  ██║",
            " ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝"
    };
    public static String[] getGameOver(){
        return GAMEOVER;
    }

    public static int getGameOverLength() {
        return 36;
    }

    private static final String[] LEADERBOARD = {
           "██╗     ███████╗ █████╗ ██████╗ ███████╗██████╗ ██████╗  ██████╗  █████╗ ██████╗ ██████╗ ",
           "██║     ██╔════╝██╔══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗██╔═══██╗██╔══██╗██╔══██╗██╔══██╗",
           "██║     █████╗  ███████║██║  ██║█████╗  ██████╔╝██████╔╝██║   ██║███████║██████╔╝██║  ██║",
           "██║     ██╔══╝  ██╔══██║██║  ██║██╔══╝  ██╔══██╗██╔══██╗██║   ██║██╔══██║██╔══██╗██║  ██║",
           "███████╗███████╗██║  ██║██████╔╝███████╗██║  ██║██████╔╝╚██████╔╝██║  ██║██║  ██║██████╔╝",
           "╚══════╝╚══════╝╚═╝  ╚═╝╚═════╝ ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ "
    };

    public static String[] getLEADERBOARD() {
        return LEADERBOARD;
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
                    "#############",
                    "######    ###",
                    "### ###   ###",
                    "###  ###  ###",
                    "###   ### ###",
                    "###    ######",
                    "#############",
                    " ########### ",
                    "  #########  "

            },
            {

                    "    ####     ",
                    "  #######    ",
                    " ########    ",
                    "  ## ####    ",
                    "     ####    ",
                    "     ####    ",
                    "     ####    ",
                    "     ####    ",
                    " ########### ",
                    "#############",
                    " ########### "
            },
            {

                    " ########### ",
                    "#############",
                    " ############",
                    "          ###",
                    "          ###",
                    " ############",
                    "#############",
                    "###          ",
                    "###          ",
                    "#############",
                    " ########### "
            },
            {

                    " ########### ",
                    "#############",
                    " ############",
                    "          ###",
                    " ############",
                    "#############",
                    " ############",
                    "          ###",
                    " ############",
                    "#############",
                    " ########### "
            },
            {

                    " #         # ",
                    "###       ###",
                    "###       ###",
                    "###       ###",
                    "#############",
                    "#############",
                    " ############",
                    "          ###",
                    "          ###",
                    "          ###",
                    "          ###"
            },
            {

                    " ########### ",
                    "#############",
                    "###          ",
                    "###          ",
                    "#############",
                    " ############",
                    "          ###",
                    "          ###",
                    " ############",
                    "#############",
                    " ########### "
            },
            {
                    " ########### ",
                    "#############",
                    "############ ",
                    "###          ",
                    "############ ",
                    "#############",
                    "#############",
                    "###       ###",
                    "#############",
                    "#############",
                    " ########### "
            },
            {

                    " ########### ",
                    "#############",
                    " ############",
                    "         ### ",
                    "        ###  ",
                    "       ###   ",
                    "      ###    ",
                    "     ###     ",
                    "    ###      ",
                    "   ###       ",
                    "  ###        "
            },

            {

                    " ########### ",
                    "#############",
                    "#############",
                    "###       ###",
                    "#############",
                    " ########### ",
                    "#############",
                    "###       ###",
                    "#############",
                    "#############",
                    " ########### "
            },
            {

                    " ########### ",
                    "#############",
                    "#############",
                    "###       ###",
                    "#############",
                    "#############",
                    " ############",
                    "          ###",
                    " ############",
                    "#############",
                    " ############ "
            },

    };
    public static String[] getNumber(int number) {
        return NUMBERS[number];
    }

    public static String[] KEYBOARD= {
            "       _____ ",
            "      || ^ ||",
            "      ||___||",
            "      |/___||",
            " ____  _____ _____",
            "|| < ||| v ||| > ||",
            "||___|||___|||___||",
            "|/___||/___||/___||"
    };

    public static String[] getKeyBoard() {
        return KEYBOARD;
    }
    public static String[] SPACE = {
            " _______________",
            "||      _       ||",
            "||______________||",
            "/_______________||"
    };

    public static String[] getSpace() {
        return SPACE;
    }


}











