describe('A suite', function() {
  return it('Validation for a term', function() {
    return expect(checkForTerm('d')).toEqual(true);
  });
});