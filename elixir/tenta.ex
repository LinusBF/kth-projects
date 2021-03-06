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
    #to_list = fn(res, n) -> List.flatten(res++[n]) end
    #reduce(tree, [], to_list)
    fairly(tree)
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

  def fairly(nil) do {:ok, 0} end
  def fairly({:node, _, lt, rt}) do
    case fairly(lt) do
      {:ok, ld} ->
        case fairly(rt) do
          {:ok, rd} ->
            cond do
              abs(ld - rd) < 2 -> {:ok, max(ld, rd) + 1}
              true -> :no
            end
          :no -> :no
        end
      :no -> :no
    end
  end

  def dillinger() do
    spawn(fn() -> dillinger(:nyc) end)
  end
  def dillinger(state) do # Initial Solution
    if state == :nyc do
      IO.puts("Hey Jim!")
    end
    receive do
      :knife -> dillinger(state, :nyc, :knife)
      :fork -> dillinger(state, :knife, :fork)
      :bottle -> dillinger(state, :fork, :bottle)
      :cork -> dillinger(state, :bottle, :nyc)
    end
  end
  def dillinger(state, correct, next) do
    if state == correct do
      dillinger(next)
    else
      dillinger(state)
    end
  end
  def betterDillinger() do
    spawn(fn() -> nyc() end)
  end
  def nyc() do
    IO.puts("Hey Jim!")
    receive do
      :knife -> knife()
    end
  end
  def knife() do
    receive do
      :fork -> fork()
    end
  end
  def fork() do
    receive do
      :bottle -> bottle()
    end
  end
  def bottle() do
    receive do
      :cork -> nyc()
    end
  end

  def foldp([n], _) do n end
  def foldp(arr, op) do
    self = self()
    {l, r} = split(arr, [], []) # Initial solution used: Enum.split(arr, Kernel.trunc(length(arr)/2))
    spawn(fn() -> n = foldp(l, op); send(self, n) end)
    spawn(fn() -> n = foldp(r, op); send(self, n) end)
    receive do
      n1 ->
        receive do
          n2 -> op.(n1, n2)
        end
    end
  end
  def split([], l1, l2) do # From the exam solution
    {l1,l2}
  end
  def split([h|t], l1, l2) do # From the exam solution
    split(t, [h | l2], l1)
  end

  def mergeSort([]) do [] end
  def mergeSort([x]) do [x] end
  def mergeSort(l) do
    {l1, l2} = split(l, [], [])
    sorted1 = mergeSort(l1)
    sorted2 = mergeSort(l2)
    merge(sorted1, sorted2)
  end
  def merge(l, []) do l end
  def merge([], l) do l end
  def merge([h1 | t1], [h2 | _] = l) when h1 < h2 do
    [h1 | merge(t1, l)]
  end
  def merge(l, [h2 | t2]) do
    [h2 | merge(t2, l)]
  end

  def quickSort([]) do [] end
  def quickSort([x]) do [x] end
  def quickSort(l) do
    {l1, l2} = splitAtPivot(l)
    quickSort(l1) ++ quickSort(l2)
  end
  def splitAtPivot([p | t]) do
    splitAtPivot(p, t, [], [])
  end
  def splitAtPivot(p, [], low, high) do {low, [p | high]} end
  def splitAtPivot(p, [h | t], low, high) when h < p do
    splitAtPivot(p, t, [h | low], high)
  end
  def splitAtPivot(p, [h | t], low, high) do
    splitAtPivot(p, t, low, [h | high])
  end


end