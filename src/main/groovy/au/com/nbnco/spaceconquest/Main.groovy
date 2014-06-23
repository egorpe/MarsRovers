package au.com.nbnco.spaceconquest

class Main {
    public static void main(String[] args) {
        Reader input = System.in.newReader()
        String[] pxy = readLine(input).split(' ')
        Plateau p = new Plateau(pxy[0] as int, pxy[1] as int)

        String nextLine = readLine(input)
        while(nextLine) {
            String[] rxyd = nextLine.split(' ')
            Rover r = new Rover(p, rxyd[0] as int, rxyd[1] as int, rxyd[2] as Rover.Direction)
            nextLine = readLine(input)
            r.execute(nextLine)
            println r
            nextLine = readLine(input)
        }
    }

    static String readLine(Reader input) {
        String line = input.readLine()
        while(line?.trim() == '') { line = input.readLine() }
        line
    }
}
