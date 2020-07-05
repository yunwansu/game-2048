
## Usage

Run the project directly:

    $ boot run

Run the project's tests (they'll fail until you edit them):

    $ boot test

Build an uberjar from the project:

    $ boot build

Run the uberjar:

    $ java -jar target/game-2048-0.1.0-SNAPSHOT-standalone.jar

## Command
 `left` `right` `up` `down`

## How to work
### move (left only)
1. remove zero
2. split
3. sum left
4. join
5. append zero
#### remove zero
    [2 0 0 0] -> [2]

#### split into duplicate tiles
    [4 2 2 4] -> [[4] [2 2] [4]]

#### sum left
    [[4] [2 2] [4]] -> [[4] [4] [4]]
    [[4] [2 2 2]]   -> [[4] [4 2]]
    [[2 2 2 2]]     -> [[4 4]]

#### join
    [[4] [4] [4]] -> [4 4 4]
    [[4] [4 2]]   -> [4 4 2]
    [[4 4]]       -> [4 4]

#### append zero
    [4 4 4] -> [4 4 4 0]
    [4]     -> [4 0 0 0]

### move right
1. reverse
2. move left
3. reverse

### move up
1. transpose
2. move left
3. transpose

### move down
1. transpose
2. move right
3. transpose