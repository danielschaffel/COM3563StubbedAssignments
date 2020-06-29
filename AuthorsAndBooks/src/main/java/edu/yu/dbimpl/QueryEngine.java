package edu.yu.dbimpl;

import java.util.Set;

/** An interface of Book/Author/etc queries.  Also a factory for the various
 * POJO artifacts returned by the queries.
 *
 * @author Avraham Leff
 */
public interface QueryEngine {

  /** Return all AuthorsInfos currently in the database.
   */
  Set<AuthorInfo> getAllAuthorInfos();

  /** Retrieve the author uniquely identified with the specified last name and
   * first name.  
   *
   * @param lastName Last name of the author, cannot be empty.
   * @param firstName First name of the author, cannot be empty.
   * @return Author if she exists in the database, null otherwise
   * @throws IllegalArgumentException if the combination of the last name and
   * first name are not unique or if something is wrong with the parameters
   */
  Author authorByName(String lastName, String firstName);

  /** Retrieve all Books with the specified title.  If no books match the
   * title, return the empty set.  Books are ordered by ISBN, and authors of a
   * given book are ordered alphabetically by last name, then first name.
   *
   * @param title Book's title.
   */
  Set<Book> booksByTitle(final String title);

  /** Create an instance of AuthorInfo.
   *
   * @throws IllegalArgumentException if something is wrong with the parameters
   */
  AuthorInfo createAuthorInfo(int authorID, String firstName, String lastName);

  /** Create a TitleInfo instance
   */
  TitleInfo createTitleInfo(final String isbn, final String title,
                            final String copyright, final int editionNumber);
  
}