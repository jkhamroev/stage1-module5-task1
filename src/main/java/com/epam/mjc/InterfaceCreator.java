package com.epam.mjc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream().allMatch(s -> s.length() >= 1 && Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evens = x.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
            x.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream().filter(s -> Character.isUpperCase(s.charAt(0))
                && s.charAt(s.length() - 1) == '.'
                && s.split(" ").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> x.stream().collect(Collectors.toMap(Function.identity(), String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            x.addAll(y);
            return x;
        };
    }
}
