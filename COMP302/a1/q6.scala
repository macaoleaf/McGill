def stringPipeline(cmd: String): (String) => String = {
  (input: String) => {
    def switch(cmd: String, input: String, result: String, pos: Int, limit: Int): String = pos match{
      case `limit` => result // return the modified string
      case _ => { // examine all chars in the cmd string
        if(cmd.charAt(pos) == 'U') switch(cmd, input, result.toUpperCase, pos + 1, cmd.length) // upper-case
        else if(cmd.charAt(pos) == 'l') switch(cmd, input, result.toLowerCase, pos + 1, cmd.length) // lower-case
        else if(cmd.charAt(pos) == 'T'){ // title-case
          def titleCase(input: String, result: String, firstChar: Boolean, pos: Int, limit: Int): String = pos match{
            case `limit` => result
            case _ => {
              if(input.charAt(pos) == ' ' && firstChar) titleCase(input, result + input.charAt(pos), true, pos + 1, input.length)
              else if(input.charAt(pos) != ' ' && firstChar) titleCase(input, result + input.charAt(pos).toUpper, false, pos + 1, input.length)
              else if(input.charAt(pos) != ' ' && input.charAt(pos-1) == ' ') titleCase(input, result + input.charAt(pos).toUpper, false, pos + 1, input.length)
              else titleCase(input, result + input.charAt(pos), false, pos + 1, input.length)
            }
          }
          switch(cmd, input, titleCase(result, "", true, 0, result.length), pos + 1, cmd.length)
        }
        else if(cmd.charAt(pos) == 'r'){ // reverse the string
          def reverse(input: String, result: String, pos: Int, limit: Int): String = pos match{
            case `limit` => result
            case _ => reverse(input, result + input.charAt(pos), pos - 1, -1)
          }
          switch(cmd, input, reverse(result, "", result.length - 1, -1), pos + 1, cmd.length)
        }
        else if(cmd.charAt(pos) == 's') switch(cmd, input, result.sorted, pos + 1, cmd.length) // sort the chars
        else if(cmd.charAt(pos) == '*'){ // delete space chars
          def deleteSpace(input: String, result: String, pos: Int, limit: Int): String = pos match{
            case `limit` => result
            case _ => {
              if(input.charAt(pos) != ' ') deleteSpace(input, result + input.charAt(pos), pos + 1, input.length)
              else deleteSpace(input, result, pos + 1, input.length)
            }
          }
          switch(cmd, input, deleteSpace(result, "", 0, result.length), pos + 1, cmd.length)
        }
        else result // keep the type as string instead of unit
      }
    }
    switch(cmd, input, input, 0, cmd.length)
  }
}