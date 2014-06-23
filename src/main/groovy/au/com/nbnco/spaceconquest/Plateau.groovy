package au.com.nbnco.spaceconquest

/**
 * This is an entity that represents Mars plateau to be explored
 */
class Plateau {
    /**
     * Upper right X coordinate of the plateau
     */
    int x

    /**
     * Upper right Y coordinate of the plateau
     */
    int y

    /**
     * Rovers that are currently deployed on the plateau
     */
    List<Rover> rovers = new ArrayList<Rover>()

    /**
     * Creates a new plateau
     */
    Plateau(int x, int y) {
        this.x = x
        this.y = y
    }

    /**
     *
     * @param rover rover to be deployed
     */
    def deploy(Rover rover) {
        validate(rover)
        rovers.add(rover)
    }

    /**
     * Check if rover is went out of plateau or collided with the other rover
     * @param rover rover to check
     * @throws RoverOutOfPlateauException if rover coordinates are out of plateau
     * @throws RoverCollisionException if a rover occupies the same coordinates as
     * one of the other deployed rovers
     */
    def validate(Rover rover) {
        if (rover.x < 0 || rover.x > x || rover.y < 0 || rover.y > y) {
            throw new RoverOutOfPlateauException()
        }

        rovers.each { Rover r ->
            if (r != rover && r.x == rover.x && r.y == rover.y) {
                throw new RoverCollisionException()
            }
        }
    }
}
