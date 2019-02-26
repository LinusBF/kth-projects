defmodule Tenta do
  def main() do
    tree = {:node, 11,
      {:node, 5,
        {:node, 3,
          nil,
          nil
        },
        {:node, 4,
          nil,
          nil
        }
      },
      {:node, 8,
        nil,
        nil
      }
    }
    #add(15, tree)
    #sumTree = fn(a, b) -> a + b end
    #reduce(tree, 0, sumTree)
    to_list = fn(res, n) -> List.flatten(res++[n]) end
    reduce(tree, [], to_list)
  end

  def double_even([h|t]) do
    case rem h, 2 do
      0 -> [2*h|double_even(t)]
      1 -> [h|double_even(t)]
    end
  end

  def double_even([]) do
    []
  end

  def sum(nil) do 0 end
  def sum({:node, i, lt, rt}) do
    sum(lt) + sum(rt) + i
  end

  def mirror(nil) do nil end
  def mirror({:node, i, lt, rt}) do
    {:node, i, mirror(rt), mirror(lt)}
  end

  def add(n, nil) do {:node, n, nil, nil} end
  def add(n, {:node, i, nil, nil}) do
    cond do
      n > i -> {:node, n, {:node, i, nil, nil}, nil}
      true -> {:node, i, {:node, n, nil, nil}, nil}
    end
  end
  def add(n, {:node, i, lt, rt}) do
    {:node, ui, ult, urt} = add(n, rt)
    cond do
      ui > i -> {:node, ui, lt, {:node, i, ult, urt}}
      true -> {:node, i, lt, {:node, ui, ult, urt}}
    end
  end

  def fizzbuzz(n) do fizzbuzz(1, n + 1, 1, 1) end

  def fizzbuzz(max, max, _, _) do [] end
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

  def reduce(nil, init, _) do
    init
  end
  def reduce({:node, i, lt, rt}, init, op) do
    self = self()
    spawn(fn() -> res = reduce(lt, init, op); send(self, {:l, res}) end)
    spawn(fn() -> res = reduce(rt, init, op); send(self, {:r, res}) end)
    receive do
      {:l, resL} ->
        receive do
          {:r, resR} -> op.(op.(resL, i), resR)
        end
    end
  end

end