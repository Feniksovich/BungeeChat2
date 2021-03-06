package dev.aura.bungeechat.testhelpers;

import dev.aura.bungeechat.account.BungeecordAccountManager;
import dev.aura.bungeechat.api.account.BungeeChatAccount;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import org.junit.BeforeClass;
import org.mockito.Mockito;

public abstract class AccountManagerTest {
  @BeforeClass
  public static void setupAccounts() {
    HelperAccountManager.addPlayer("test");
    HelperAccountManager.addPlayer("player1");
    HelperAccountManager.addPlayer("player2");
    HelperAccountManager.addPlayer("hello");
  }

  @UtilityClass
  private static class HelperAccountManager extends BungeecordAccountManager {
    private static long id = 0;

    public static void addPlayer(String name) {
      final UUID uuid = new UUID(0, id++);
      final BungeeChatAccount account = Mockito.mock(BungeeChatAccount.class);

      Mockito.when(account.getUniqueId()).thenReturn(uuid);
      Mockito.when(account.getName()).thenReturn(name);

      accounts.put(uuid, account);
    }
  }
}
