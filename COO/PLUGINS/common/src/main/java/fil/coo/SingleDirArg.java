package fil.coo;

public class SingleDirArg {

    public static String getResourceDir(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("This program only accepts one argument which is the directory to watch");
        }
        return args[0];
    }

}
