defmodule Test do
  @moduledoc false

  def main do
    4 + 2
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
