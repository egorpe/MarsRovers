package au.com.nbnco.spaceconquest

import spock.lang.Specification

class MarsRoversSpec extends Specification {
    def "test from the task description"() {
        when:
        Plateau p = new Plateau(5, 5)

        Rover r1 = new Rover(p, 1, 2, Rover.Direction.N)
        r1.execute('LMLMLMLMM')

        Rover r2 = new Rover(p, 3, 3, Rover.Direction.E)
        r2.execute('MMRMMRMRRM')

        then:
        r1.x == 1
        r1.y == 3
        r1.direction == Rover.Direction.N

        r2.x == 5
        r2.y == 1
        r2.direction == Rover.Direction.E
    }

    def "deploy outside of the plateau"() {
        when:
        Plateau p = new Plateau(5, 5)
        new Rover(p, 1, 6, Rover.Direction.N)

        then:
        thrown(RoverOutOfPlateauException)
    }

    def "rovers are on a collision course"() {
        when:
        Plateau p = new Plateau(5, 5)
        new Rover(p, 1, 2, Rover.Direction.N)
        Rover r = new Rover(p, 0, 2, Rover.Direction.E)
        r.execute('M')

        then:
        thrown(RoverCollisionException)
    }
}
