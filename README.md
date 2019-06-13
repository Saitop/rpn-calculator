# RPN Calculator

Written by Hanxian Lin

## usage:
below command should be run at project root diretory

test:
```
./gradlew test
```

build project:
```
./gradlew build
```


to run program as jar
```
./gradlew build

java -jar ./build/libs/rpn-calculator-1.0-SNAPSHOT.jar
```

---------------------------------

PS:
Some thoughts to improve the my implementation:

To Use an enum called 'Operator' to conclude all execution
that spread in every kind of 'Token', like 'AST' to classify syntax.

But the 'switch' case to handle different input string is inevitable.

Depends on the personal aestheticism.

like:
````
public enum Operator {
    Addition() {
        @Override
        public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws CalculatorException {
        if (tokens.size() < 2) {
            throw new InsufficientParamsException();
        }

        final Token addend = tokens.pop();
        final Token augend = tokens.pop();
        final Double sum = Double.valueOf(augend.getValue()) + Double.valueOf(addend.getValue());

        tokens.push(new NumberToken(sum.toString()));
        final Step step = new Step(Arrays.asList(augend, addend), this);
        cachedSteps.push(step);
        }
    },

    //.....

    Number() {
        @Override
        public void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws CalculatorException  {
            final Step step = new Step(Collections.emptyList(), null);
            cachedNumbers.push(step);
        }
    };

    public abstract void execute(Stack<Token> tokens, Stack<Step> cachedNumbers) throws CalculatorException;
}
```
