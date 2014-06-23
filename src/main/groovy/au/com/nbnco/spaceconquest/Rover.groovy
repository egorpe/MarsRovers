package au.com.nbnco.spaceconquest

/**
 * This is an entity that represents a rover.
 */
class Rover {
    enum Direction { N, E, S, W }

    /**
     * X coordinate of the rover location on the plateau
     */
    int x

    /**
     * Y coordinate of the rover location on the plateau
     */
    int y

    /**
     * The direction rover point to
     */
    Direction direction

    /**
     * The plateau on which rover is deployed
     */
    Plateau plateau

    /**
     * Deploy a Rover on a Plateau
     * @param plateau plateau to deploy the rover on
     * @param x initial x coordinate
     * @param y initial y coordinate
     * @param direction initial directon
     */
    Rover(Plateau plateau, int x, int y, Direction direction) {
        this.plateau = plateau
        this.x = x
        this.y = y
        this.direction = direction
        plateau.deploy(this)
    }

    /**
     * Execute the NASA command
     * @param command te NASA command
     */
    def execute(String command) {
        command.every {
            switch(it) {
                case 'L':
                    left()
                    break
                case 'R':
                    right()
                    break
                case 'M':
                    move()
                    break
                default:
                    throw new IllegalArgumentException('Command not recognised')
            }
        }
    }

    private left() {
        switch(direction) {
            case Direction.N:
                direction = Direction.W
                break
            case Direction.E:
                direction = Direction.N
                break
            case Direction.S:
                direction = Direction.E
                break
            case Direction.W:
                direction = Direction.S
                break
        }
    }

    private right() {
        switch(direction) {
            case Direction.N:
                direction = Direction.E
                break
            case Direction.E:
                direction = Direction.S
                break
            case Direction.S:
                direction = Direction.W
                break
            case Direction.W:
                direction = Direction.N
                break
        }
    }

    private move() {
        switch(direction) {
            case Direction.N:
                this.y++
                break
            case Direction.E:
                this.x++
                break
            case Direction.S:
                this.y--
                break
            case Direction.W:
                this.x--
                break
        }
        plateau.validate(this)
    }

    @Override
    public String toString() {
        "${x}  ${y}  ${direction}"
    }
}
