package com.mishiranu.dashchan.chan.kohlchan;

import chan.content.ChanConfiguration;

public class KohlchanChanConfiguration extends ChanConfiguration
{
	public KohlchanChanConfiguration()
	{
		request(OPTION_READ_POSTS_COUNT);
		setDefaultName("Bernd");
	}

	@Override
	public Board obtainBoardConfiguration(String boardName)
	{
		Board board = new Board();
		board.allowCatalog = true;
		board.allowPosting = true;
		board.allowDeleting = true;
		board.allowReporting = false; // See Performer: Needs CAPTCHA to report a post
		return board;
	}

	@Override
	public Posting obtainPostingConfiguration(String boardName, boolean newThread)
	{
		Posting posting = new Posting();
		boolean namesAndEmails = !"layer".equals(boardName);
		posting.allowName = false;
		posting.allowSubject = true;
		posting.optionSage = namesAndEmails;
		posting.hasCountryFlags = "int".equals(boardName);

		posting.attachmentSpoiler = true;
		posting.attachmentCount = 4;
		posting.attachmentMimeTypes.add("image/jpeg");
		posting.attachmentMimeTypes.add("image/jpg");
		posting.attachmentMimeTypes.add("image/bmp");
		posting.attachmentMimeTypes.add("image/gif");
		posting.attachmentMimeTypes.add("image/png");
		posting.attachmentMimeTypes.add("video/webm");
		posting.attachmentMimeTypes.add("video/mp4");
		posting.attachmentMimeTypes.add("audio/mp3");
		posting.attachmentMimeTypes.add("audio/ogg");
		posting.attachmentMimeTypes.add("audio/flac");
		posting.attachmentMimeTypes.add("audio/opus");
		posting.attachmentMimeTypes.add("application/epub+zip");
		posting.attachmentMimeTypes.add("application/zip");
		posting.attachmentMimeTypes.add("application/pdf");
		posting.attachmentMimeTypes.add("text/plain");
		return posting;
	}

	@Override
	public Deleting obtainDeletingConfiguration(String boardName)
	{
		Deleting deleting = new Deleting();
		deleting.password = true;
		deleting.multiplePosts = true;
		deleting.optionFilesOnly = true;
		return deleting;
	}

	@Override
	public Reporting obtainReportingConfiguration(String boardName)
	{
		Reporting reporting = new Reporting();
		reporting.comment = true;
		reporting.multiplePosts = true;
		return reporting;
	}
}
