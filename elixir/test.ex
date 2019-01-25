defmodule Test do
  @moduledoc false

  def main do
    4 + 2
  end

  def insert(x, []) do
    [x]
  end

  def insert(x, [h | t]) do
    case x < h do
      true ->
        [x | [h | t]]
      false ->
        [h | insert(x, t)]
    end
  end

  def isort(l) do
    isort(l, [])
  end

  def isort([], sorted) do
    sorted
  end

  def isort([h | t], sorted) do
    isort(t, insert(h, sorted))
  end

  def ack(m, n) do
    cond do
      m == 0 ->
        n + 1
      n == 0 ->
        ack(m - 1, 1)
      true ->
        ack(m - 1, ack(m, n - 1))
    end
  end
end
