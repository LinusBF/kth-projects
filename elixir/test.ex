defmodule Test do
  @moduledoc false

  def main do
    4 + 2
  end

  def insert(x, l) do
    case l do
      [] ->
        [x]
      [h | t] when h < x ->
        [h | insert(x, t)]
      [h | t] ->
        [x | [h | t]]
    end
  end

  def isort(l) do
    isort(l, [])
  end

  def isort(list, sorted) do
    case sorted do
      [] ->
        [h | t] = list
        isort(t, [h])
      [h | t] when h < list ->
        [h2 | t2] = list
        isort(t2, insert(h2, sorted))
      [h | t] ->
        [h2 | t2] = list
        [h2 | isort(t2, sorted)]
    end
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
