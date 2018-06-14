package org.duh102.duhbot.hugplugin;

import java.util.*;
import java.util.regex.*;

import org.pircbotx.hooks.*;
import org.pircbotx.hooks.events.*;

import org.duh102.duhbot.functions.*;

public class HugPlugin extends ListenerAdapter implements DuhbotFunction
{
  static Pattern hugPattern = Pattern.compile("^hugs? .+");
  public HashMap<String,String> getHelpFunctions()
  {
    HashMap<String,String> helpFunctions = new HashMap<String,String>();
    helpFunctions.put("hugs", "Hugs you back whenever you hug the bot! (use /me hugs [botname])");
    return helpFunctions;
  }
  
  public String getPluginName()
  {
    return "Hug Plugin";
  }
  
  public ListenerAdapter getAdapter()
  {
    return this;
  }
  
  public HugPlugin()
  {
  }
  
  String message;
  public void onAction(ActionEvent event)
  {
    message = org.pircbotx.Colors.removeFormattingAndColors(event.getAction()).trim().toLowerCase();
    Matcher hugMatch = hugPattern.matcher(message);
    if(hugMatch.matches() && message.endsWith(event.getBot().getNick().toLowerCase()))
    {
      event.respond("hugs " + event.getUser().getNick());
    }
  }
}
