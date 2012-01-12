package com.coremedia.codekata.wordwrap;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the implementations of LineWrapper, that are registered in {@link AbstractDataDrivenLineWrapperTest#data()}.
 * @deprecated
 */
@Ignore
public final class LineWrapperTest extends AbstractDataDrivenLineWrapperTest {

  public LineWrapperTest(final LineWrapper wrapper) {
    super(wrapper);
  }

  @Test
  public void dontBreakShortLine() {
    String line = "Please don't wrap me!";
    Assert.assertEquals(line, wrapper.wrap(line, 100));
  }

  @Test
  public void wrapOneTime() {
    String line = "Please wrap me!";
    String expected = "Please\nwrap me!";

    String actual = wrapper.wrap(line, 10);

    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testUnwrappable() throws Exception {
    String line = "abcdefghijklmnopqrstuvwxy z";
    String expected = "abcdefghijklmnopqrstuvwxy\nz";
    Assert.assertEquals(expected, wrapper.wrap(line, 5));

    line = "abc defghijklmnopqrstuvwxyz";
    expected = "abc\ndefghijklmnopqrstuvwxyz";
    Assert.assertEquals(expected, wrapper.wrap(line, 5));
  }

  @Test
  public void testBoundaries() throws Exception {
    String line = "abcd efghijk lmno pqrstuv wxy z";
    String expected = line;
    Assert.assertEquals(expected, wrapper.wrap(line, 0));

    line = "a b c d e";
    expected = "a\nb\nc\nd\ne";
    Assert.assertEquals(expected, wrapper.wrap(line, 1));


  }
}
