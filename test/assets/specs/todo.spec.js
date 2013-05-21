describe("A suite", function() {

    it("hello", function() {
        expect(hello()).toBe("hello");
    });
});

describe("A suite", function() {

     it("another function returning false", function() {
           expect(myFunc()).toBe(true);
      });

      it("simple function returning a string", function() {
           expect(simpleFunction()).toBe("simple function");
      });

      it("term that is not null returning true", function() {
           expect(checkForTerm('s')).toBe(true);
      });

 });


