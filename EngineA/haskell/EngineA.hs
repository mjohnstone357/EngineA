
module EngineA where

-- The encoding of solutions.
type Bitstring = [Bool]

-- Components can be considered helpful or harmful.
data Modifier = Helpful | Harmful
              deriving (Read, Show, Eq)

-- Things are assigned credits, which give an indication of their predictive power / utility.
data Credits = Credits Int
             deriving (Read, Show)

-- The model has two kinds of component- references to individual bits, and composites of those
-- references and other composites.
data ModelComponent = Bit BitOpinion | Comp Composite
                    deriving (Read, Show)

-- A bit opinion expresses something like 'bit x being set is Helpful'.
type BitOpinion = (Int, Modifier)

type Composite = [(ModelComponent, Modifier)]

-- Note: don't worry about sharing resources :)

type Complexity = Int

data EngineState = EngineState {
  sessionName :: String,
  generation :: Int,
  complexityCeiling :: Complexity,
  model :: [(ModelComponent,Credits)]  
}

-- TODO Do this properly.
reduceModel :: EngineState -> EngineState
reduceModel state = state {model = (drop 1 (model state))}
               

inverse :: Modifier -> Modifier
inverse Helpful = Harmful
inverse Harmful = Helpful

evalBitOpinion :: Bitstring -> BitOpinion -> Modifier
evalBitOpinion bitstring (index, modifier) =
  let bit = bitstring !! index in
  if bit
  then modifier
  else inverse modifier

evalComposite :: Bitstring -> Composite -> Modifier
evalComposite bitstring components =
  let helpfulCount = getModifierCount Helpful bitstring components 
      harmfulCount = getModifierCount Harmful bitstring components in
  if helpfulCount >= harmfulCount
  then Helpful
  else Harmful
       
getModifierCount :: Modifier -> Bitstring -> Composite -> Int
getModifierCount modifier bitstring ((component,_):rest) =
  
  let relevantModifier = case component of
        Bit bitOpinion ->  evalBitOpinion bitstring bitOpinion
        Comp composite -> evalComposite bitstring composite
  in
  
   let this = if relevantModifier == modifier
              then 1
              else 0
   in
    this + (getModifierCount modifier bitstring rest)
getModifierCount _ _ [] = 0

opt :: Bitstring
opt = readBin "11000111"

readBin :: String -> Bitstring
readBin (x:xs) =
  let this = if x == '1'                
             then True
             else False
  in
   this : (readBin xs)
   
readBin [] = []
