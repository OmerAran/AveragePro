import React from "react"

type Props = TodoProps & {
    getPro: (_id: number) => void
}

const Todo: React.FC<Props> = ({ pro, getPro }) => {
  const checkTodo: string = pro.status ? `line-through` : ""
  return (
    <div className="Card">
      <div className="Card--text">
        <h1 className={checkTodo}>{pro.salary}</h1>
       
      </div>
      <div className="Card--button">
        <button
          onClick={() => getPro(pro._id)}
          className="Card--button__delete"
        >
          show avg salary
        </button>
      </div>
    </div>
  )
}

export default Todo