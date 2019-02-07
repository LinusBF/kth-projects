defmodule Env do

  def new() do
    []
  end

  def add(id, str, env) do
    [{id, str} | env]
  end

  def lookup(id, env) do
    List.keyfind(env, id, 0)
  end

  def remove(ids, env) do
    case ids do
      [] ->
        env
      [h] ->
        remove([], List.keydelete(env, h, 0))
      [h | t] ->
        case lookup(h, env) do
          nil -> remove(t, env)
          {h, _} ->
            remove(ids, List.keydelete(env, h, 0))
        end
    end
  end
end