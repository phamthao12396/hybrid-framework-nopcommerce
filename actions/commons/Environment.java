package commons;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "file:envConfig/${env}.properties" })
public interface Environment extends Config {
	@Key("url")
	String appUrl();

	@Key("db.url")
	String dbHost();

	@Key("db.username")
	String dbUsername();

	@Key("db.pass")
	String dbPass();
}
