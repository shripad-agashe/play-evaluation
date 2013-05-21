describe "A suite", ->
     it "says hello", ->
        expect(hello()).toEqual "hello"
###ANOTHER SUITE###
describe "A suite", ->
     it "another function returning false", ->
         expect(myFunc()).toBe true
     it "simple function returning a string", ->
         expect(simpleFunction()).toEqual "simple function"
     it "term that is not null returning true", ->
         expect(checkForTerm('s')). toBe true
