## Non Private Fields

Fields should be private, or else the client
can access/mess with them. This would be bad.

## Extra Fields

Unnecessary Fields -- Fields should only be used
or information that needs to be maintained through
many different method calls.

## Field Initialized at declaration rather than in methods

You should initialize your fields in the constructor
or other methods. It's a style issue, but doesn't change anything code wise.

## Constructor Comment lacking or nonexistant

You probably want to talk about the initial state
of the object -- like that theres 0 Tiles(even if
that seems like it might be obvious)

## Shuffle Comment doesn't mention width/height

You should document how the positions get reordered. For example,
it's important to note that every box will be completely contained
in the screen(no off screen)

## Comments mentions index of tile.

Don't mention the index -- the client doesn't know how you order the
tiles in the inside. You could have had the ArrayList backwards and
the client wouldn't notice.  Talking about tiles in terms of top of
pile/bottom of pile is fine though.

## Comments mention ArrayList

Implementation details -- don't let the client know that you are using
an ArrayList. You could use 9001 different Tile variables for all they
care, as long as it works.

## Comments mention TileMain

Don't mention TileMain -- Your class should work and be useful for a different
client that happens to need to manage Tiles.

## Terribad Style of Curlies

You should consider putting these on the rightmost edge of the line above.
I guess one might consider it a nice feature that the curlies line up,
but you can tell by the indentation anyway. It's more useful that you don't waste lines on curlies. 

## Comments mention left-click right-click etc

Don't mention how your methods might be triggered -- somebody else could make
a client that runs your methods in different situations

## Comment Abstraction -- mentions mouse when parameters are just coordinates

Try to take the abstraction further -- your parameters are just coordinates, 
so this method will be useful even for functionality unrelated to the mouse

## Do Everything Method

This is more of a `do everything` method than a helper.
Helpers should only contain the details that are the same for each method...
for example, a useful function that only does the similar details would be one
that finds the index of the topmost Tile given coordinates.
Each individual method could use that helper but handle the rest itself

## Overcomplicated topMost Tile search

I think that you overcomplicated this problem a little bit.
Check out the Jan11 Lecture version of the ArrayList's indexOf
method to see an extremely similar problem

## Use of break

Uses break statements to escape loops -- Reasons for escaping a 
loop should be contained within the for loop condition.

Even a boolean variable flag called hasAlreadyOperated
(which needs to be false) would be better than the break.

You could also use return; to short circuit the method -- it's a little more comfortable than break
because you don't have to consider any possibilities for what happens after the loop.
ut it's still sort of crusty for many of the same reasons.

## tileContains redundancy

Didn't reduce all redundancy -- A tileContainsCoordinates private helper function would have been useful.

## Terribad names

Use variable and method names that describe the purpose of the item
