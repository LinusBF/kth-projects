defmodule Tenta do
  def main() do

  end

  def fizzbuzz(n) do fizzbuzz(1, n + 1, 1, 1) end

  def fizzbuzz(max, max, three, five) do [] end
  def fizzbuzz(i, max, 3, 5) do
    [:fizzbuzz | fizzbuzz(i + 1, max, 1, 1)]
  end
  def fizzbuzz(i, max, 3, five) do
    [:fizz | fizzbuzz(i + 1, max, 1, five + 1)]
  end
  def fizzbuzz(i, max, three, 5) do
    [:buzz | fizzbuzz(i + 1, max, three + 1, 1)]
  end
  def fizzbuzz(i, max, three, five) do
    [i | fizzbuzz(i + 1, max, three + 1, five + 1)]
  end

end